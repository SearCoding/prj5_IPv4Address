package prj5_IPv4Address;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int count = 0;

        while (count < 5) {
            runProject();
            count++;
        }

        sc.close();
    }

    public static void runProject() {
        int a, b, c, d, e, f, g, h;

        System.out.println("Type in an IPv4 Address (Format 192 168 90 15): ");

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        System.out.println("Type in the subnet mask (Format 255 255 255 255): ");

        e = sc.nextInt();
        f = sc.nextInt();
        g = sc.nextInt();
        h = sc.nextInt();

        IPv4Address_Class host = new IPv4Address_Class(a, b, c, d);
        IPv4Address_Class mask = new IPv4Address_Class(e, f, g, h);
        IPv4Address_Class network;
        IPv4Address_Class firstHost;
        IPv4Address_Class lastHost;

        System.out.println();
        System.out.println("Host Address: " + host.toString());
        System.out.println("Subnet Mask: " + mask.toString());
        network = host.identifyNetworkAddress(mask);
        System.out.println("Network Address: " + network.toString());
        firstHost = network.identifyFirstHost();
        System.out.println("First Host: " + firstHost.toString());
        lastHost = network.identifyLastHost(mask);
        System.out.println("Last Host Address: " + lastHost.toString());

        System.out.println("\nNasir Deshields - 3/29/2024");
    }
}
