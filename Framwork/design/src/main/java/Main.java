import design.adapter.*;
import design.singleton.Aclazz;
import design.singleton.BClazz;
import design.singleton.SocketClient;

public class Main {
    public static void main(String[] args) {

        /*Aclazz aClazz = new Aclazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));*/

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner arAirConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(arAirConditioner);
        connect(airAdapter);
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
