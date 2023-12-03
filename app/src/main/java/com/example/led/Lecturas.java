package com.example.led;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class Lecturas extends Fragment {
    private static final String TAG = "WebSocketExample";
    private WebSocketClient webSocketClient;
    private ImageView imageView;
    private TextView distanceTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_lecturas, container, false);
        distanceTextView = rootView.findViewById(R.id.distanceTextView);
        imageView = rootView.findViewById(R.id.auto1);
        connectWebSocket();
        return rootView;

    }

    private void connectWebSocket() {
        URI uri;
        try {
            uri = new URI("ws://192.168.159.99:81");  // Replace with your server IP
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.i(TAG, "WebSocket connection opened");
            }

            @Override
            public void onMessage(String message) {
                Log.i(TAG, "Received message: " + message);

                String[] parts = message.split(" ");
                if (parts.length >= 2) {
                    final String distance = parts[1];

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(TAG, "Updating TextView with distance: " + distance);
                            distanceTextView.setText("Distancia: " + distance + " cm");
                        }
                    });
                    int distanceValue = Integer.parseInt(distance);

                    // Si la distancia es mayor a 100 cm, cambiamos el color de la imagen a rojo
                    if (distanceValue > 100) {
                        imageView.setColorFilter(Color.RED);
                    } else {
                        // Si la distancia es menor o igual a 100 cm, restauramos el color original
                        imageView.setColorFilter(null);
                    }

                }

            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.i(TAG, "WebSocket connection closed");
            }

            @Override
            public void onError(Exception ex) {
                Log.e(TAG, "WebSocket error: " + ex.getMessage());
            }
        };

        webSocketClient.connect();
    }
}