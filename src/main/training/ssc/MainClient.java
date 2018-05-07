package main.training.ssc;

import com.blogspot.debukkitsblog.net.Client;
import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import com.blogspot.debukkitsblog.net.Server;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClient extends Client {

    public MainClient(String id, String groupname) {
        super("192.168.0.10", 8000, 5000, false, false, id, groupname);

        registerMethod("NEW_CHAT_MSG", new Executable() {
            @Override
            public void run(Datapackage pack, Socket socket) {
                System.out.println("[CHAT] " + pack.get(1) + " :: " + pack.get(2));
            }
        });

        registerMethod("KOCH_BEFEHL", new Executable() {
            @Override
            public void run(Datapackage pack, Socket socket) {
                System.out.println("koche Kaffee ...");
            }
        });

        start();
    }
}
