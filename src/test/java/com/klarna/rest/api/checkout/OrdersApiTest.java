/*
 * Copyright 2018 Klarna AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.klarna.rest.api.checkout;

import com.klarna.rest.*;
import com.klarna.rest.model.checkout.Order;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrdersApiTest extends TestCase {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private FakeHttpUrlConnectionTransport transport;

    @Before
    public void setUp() throws IOException {
        transport = new FakeHttpUrlConnectionTransport();
    }

    @Test
    public void testCreateOrder() throws IOException {
        when(transport.conn.getResponseCode()).thenReturn(201);
        when(transport.conn.getHeaderFields()).thenReturn(new HashMap<String, List<String>>(){{
            put("Content-Type", new ArrayList<String>(){
                {
                    add(MediaType.APPLICATION_JSON);
                }
            });
        }});

        final String payload = "{\"order_amount\": 200}";
        when(transport.conn.getInputStream()).thenReturn(this.makeInputStream(payload));

        Order data = new Order(){
            {
                setOrderAmount(100L);
                setLocale("en-GB");
                setRecurring(true);
            }
        };

        OrdersApi api = new OrdersApi(transport);
        Order order = api.create(data);

        assertEquals(new Long(200), order.getOrderAmount());
        verify(transport.conn, times(1)).setRequestMethod("POST");
        assertEquals("/checkout/v3/orders", transport.requestPath);
        assertTrue(transport.requestPayout.toString().contains("\"order_amount\":100"));
        assertTrue(transport.requestPayout.toString().contains("\"locale\":\"en-GB\""));
        assertTrue(transport.requestPayout.toString().contains("\"recurring\":true"));
    }

    @Test(expected = ApiException.class)
    public void testCreateOrderWrongResponseCode() throws IOException {
        when(transport.conn.getResponseCode()).thenReturn(403);

        OrdersApi api = new OrdersApi(transport);
        Order order = api.create(null);
    }

    @Test(expected = ProtocolException.class)
    public void testCreateOrderWrongSuccessfulResponseCode() throws IOException {
        when(transport.conn.getResponseCode()).thenReturn(204);

        OrdersApi api = new OrdersApi(transport);
        Order order = api.create(null);
    }

    @Test(expected = ContentTypeException.class)
    public void testCreateOrderWrongContentType() throws IOException {
        when(transport.conn.getResponseCode()).thenReturn(201);
        when(transport.conn.getHeaderFields()).thenReturn(new HashMap<String, List<String>>(){{
            put("Content-Type", new ArrayList<String>(){
                {
                    add(MediaType.APPLICATION_OCTET_STREAM);
                }
            });
        }});

        OrdersApi api = new OrdersApi(transport);
        Order order = api.create(null);
    }

    @Test
    public void testFetchOrderByID() throws IOException {
        when(transport.conn.getResponseCode()).thenReturn(200);
        when(transport.conn.getHeaderFields()).thenReturn(new HashMap<String, List<String>>(){{
            put("Content-Type", new ArrayList<String>(){
                {
                    add(MediaType.APPLICATION_JSON);
                }
            });
        }});

        final String payload = "{\"order_amount\": 100}";
        when(transport.conn.getInputStream()).thenReturn(this.makeInputStream(payload));

        OrdersApi api = new OrdersApi(transport);
        Order order = api.fetch("order-id-123");

        assertEquals(new Long(100), order.getOrderAmount());
        verify(transport.conn, times(1)).setRequestMethod("GET");
        assertEquals("/checkout/v3/orders/order-id-123", transport.requestPath);
    }

    @Test
    public void testFetchOrderByLocation() throws IOException {
        when(transport.conn.getResponseCode()).thenReturn(200);
        when(transport.conn.getHeaderFields()).thenReturn(new HashMap<String, List<String>>(){{
            put("Content-Type", new ArrayList<String>(){
                {
                    add(MediaType.APPLICATION_JSON);
                }
            });
            put("Location", new ArrayList<String>(){
                {
                    add("https://example.com/order-123");
                }
            });
        }});

        final String payload = "{\"order_amount\": 100}";
        when(transport.conn.getInputStream()).thenReturn(this.makeInputStream(payload));

        OrdersApi api = new OrdersApi(transport);
        api.fetch("order-id-123");

        // Location header should be set up
        api.fetch(); // Fetch by location header
        assertEquals("https://example.com/order-123", transport.requestPath);
    }

    @Test
    public void testFetchOrderByEmptyLocation() throws IOException {
        expectedEx.expect(IOException.class);
        expectedEx.expectMessage("Unknown location");

        OrdersApi api = new OrdersApi(transport);
        api.fetch();
    }

    //@Test
    public void testUpdateOrder() throws IOException {
        when(transport.conn.getResponseCode()).thenReturn(200);
        when(transport.conn.getHeaderFields()).thenReturn(new HashMap<String, List<String>>(){{
            put("Content-Type", new ArrayList<String>(){
                {
                    add(MediaType.APPLICATION_JSON);
                }
            });
        }});

        final String payload = "{\"order_amount\": 200}";
        when(transport.conn.getInputStream()).thenReturn(this.makeInputStream(payload));

        Order data = new Order(){
            {
                setOrderAmount(100L);
                setLocale("en-GB");
                setRecurring(true);
            }
        };

        OrdersApi api = new OrdersApi(transport);
        Order order = api.create(data);

        assertEquals(new Long(200), order.getOrderAmount());
        verify(transport.conn, times(1)).setRequestMethod("POST");
        assertEquals("/checkout/v3/orders", transport.requestPath);
    }
}