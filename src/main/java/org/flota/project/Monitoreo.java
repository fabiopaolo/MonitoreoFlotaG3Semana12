package org.flota.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import ch.hsr.geohash.GeoHash;
import redis.clients.jedis.Jedis;


public class Monitoreo extends WebSocketServer {

    private Jedis jedis = new Jedis("localhost", 6379);
    private Integer dinamicID = 0;
    private static Map<Integer, WebSocket> userIDConn = new ConcurrentHashMap<>();


	public Monitoreo( int port ) throws UnknownHostException {
		super( new InetSocketAddress( port ) );
	}

	public Monitoreo( InetSocketAddress address ) {
		super( address );
	}

    public Monitoreo(int port, Draft_6455 draft) {
		super( new InetSocketAddress( port ), Collections.<Draft>singletonList(draft));
	}

	@Override
	public void onOpen( WebSocket conn, ClientHandshake handshake ) {
        // Save connection
        userIDConn.put(dinamicID++, conn);

        System.out.println(userIDConn.toString());

		conn.send("Welcome to the server!");
		//broadcast( "Nuevo conductor: " + handshake.getResourceDescriptor() );  //change by short uuid
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " vehículo nuevo en el monitoreo!" );
	}

	@Override
	public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
		broadcast( conn + " conductor se retiró." );
		System.out.println( conn + " conductor se retiró." );
	}

	@Override
	public void onMessage( WebSocket conn, String message ) {

        // XXX: multiple instances gson
        Gson gson = new Gson();
        Map map = gson.fromJson(message, Map.class);
        
        String toID = (String)map.get("toID");
		System.out.println( toID );
		double lat = (double)map.get("latitude");
		System.out.println( lat );
		double lon = (double)map.get("longitude");
		System.out.println( lon );

        GeoHash geo = GeoHash.withCharacterPrecision(lat, lon, 10);
        
        // Store string representation of coordinates against geohash key as separate entities
        //this.jedis.set(geo.toBase32(), geo.toString());
        this.jedis.set(toID, geo.toString());
        // Create Geometry
        // Store geo-spatial index against value.  Here, value is the key we retrieve by, from the database.
        this.jedis.geoadd("flota", lon, lat, geo.toBase32());



        // Send message to receptor
        userIDConn.get(Integer.parseInt(toID)).send(geo.toString());
        // dibujar punto conductor

	}
	@Override
	public void onMessage( WebSocket conn, ByteBuffer message ) {
		broadcast( message.array() );
		System.out.println( conn + ": " + message );
	}


	public static void main( String[] args ) throws InterruptedException , IOException {
		int port = 8887; // 843 flash policy port
		try {
			port = Integer.parseInt( args[ 0 ] );
		} catch ( Exception ex ) {
		}
		Monitoreo s = new Monitoreo( port );
        s.start();
        System.out.println( "Monitoreo started on port: " + s.getPort() );

		BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
		while ( true ) {
			String in = sysin.readLine();
			s.broadcast( in );
			if( in.equals( "exit" ) ) {
				s.stop(1000);
				break;
			}
		}
    }
    
    private static void broadcastMessage(String to, String message) {
        // get connection from hashmap ? redis
        // send message

    }

	@Override
	public void onError( WebSocket conn, Exception ex ) {
		ex.printStackTrace();
		if( conn != null ) {
			// some errors like port binding failed may not be assignable to a specific websocket
		}
	}

	@Override
	public void onStart() {
		System.out.println("Server started!");
		setConnectionLostTimeout(0);
		setConnectionLostTimeout(100);
	}

}