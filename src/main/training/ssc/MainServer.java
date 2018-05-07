package main.training.ssc;

import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import com.blogspot.debukkitsblog.net.Server;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainServer extends Server {

    public MainServer() {
        super(8000,true,true, false);
    }

    @Override
    public void preStart() {

        this.registerMethod("TIME_REQUEST", new Executable() {
            @Override
            public void run(Datapackage pack, Socket socket) {
                String aktuellesDatumMitZeit = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
                sendReply(socket, aktuellesDatumMitZeit);
            }
        });

        registerMethod("ANOTHER_REQUEST", new Executable() {
            @Override
            public void run(Datapackage pack, Socket socket) {
                System.out.println("I got a message: " + pack);
                sendReply(socket, "OK");
            }
        });
    }
}
