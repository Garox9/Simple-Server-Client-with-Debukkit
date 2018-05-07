package main.training.ssc;

import com.blogspot.debukkitsblog.net.Datapackage;

public class SSCNetzwerkTester {

    public static void main(String[] args) {

        MainServer server = new MainServer();
        MainClient client = new MainClient("KAFFEE1", "Kaffeeautomaten");
        MainClient client1 = new MainClient("KAFFEE2", "Kaffeeautomaten");

        server.setMuted(true);
        client.setMuted(true);
        client1.setMuted(true);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Server hat aktuell " + server.getClientCount() + " Klienten");

        Datapackage antwortVomServer = client1.sendMessage(new Datapackage("TIME_REQUEST", ":)"));
        System.out.println(antwortVomServer + "\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        client.sendMessage("ANOTHER_REQUEST", "LA LA LAND ...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        server.broadcastMessage(new Datapackage("NEW_CHAT_MSG", "DeBukkit", "Aller Anfang is schwer"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        server.broadcastMessageToGroup("Brotbackautomaten", new Datapackage("BACK_BEFEHL", "LA LA ..."));
        server.broadcastMessageToGroup("Kaffeeautomaten", new Datapackage("KOCH_BEFEHL", "MACH_KAFFEE"));

    }
}
