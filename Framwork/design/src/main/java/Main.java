import design.adapter.*;
import design.aop.AopBrowser;
import design.proxy.Browser;
import design.proxy.IBrowser;
import design.singleton.Aclazz;
import design.singleton.BClazz;
import design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        /*Aclazz aClazz = new Aclazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));*/

        /*HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner arAirConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(arAirConditioner);
        connect(airAdapter);*/

        /*Browser browser = new Browser("www.naver.com");
        browser.show();*/

        /*IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();*/

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {

        electronic110V.powerOn();
    }
}
