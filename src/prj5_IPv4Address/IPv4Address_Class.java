package prj5_IPv4Address;

public class IPv4Address_Class {
    
    private int o1, o2, o3, o4;

    public IPv4Address_Class(){}

    public IPv4Address_Class(int a, int b, int c, int d){
        this.o1 = a;
        this.o2 = b;
        this.o3 = c;
        this.o4 = d;
    }

    public int getoctectOne(){
        return o1;
    }

    public int getoctectTwo(){
        return o2;
    }

    public int getoctectThree(){
        return o3;
    }

    public int getoctectFour(){
        return o4;
    }

    public IPv4Address_Class identifyNetworkAddress(IPv4Address_Class mask){
        IPv4Address_Class network;

        int o1, o2, o3, o4;

        o1 = this.o1 & mask.o1;
        o2 = this.o2 & mask.o2;
        o3 = this.o3 & mask.o3;
        o4 = this.o4 & mask.o4;

        network = new IPv4Address_Class(o1, o2, o3, o4);
        return network;
    }

    public IPv4Address_Class identifyFirstHost(){

         
        o4++;
        IPv4Address_Class firstHost = new IPv4Address_Class(o1, o2, o3, o4);

        return firstHost;

        
    }

    public IPv4Address_Class identifyLastHost(IPv4Address_Class mask){
        
        int o1, o2, o3, o4;

        o1 = ~mask.getoctectOne();
        o2 = ~mask.getoctectTwo();
        o3 = ~mask.getoctectThree();
        o4 = ~mask.getoctectFour();

        o1 = o1 & 0xff;
        o2 = o2 & 0xff;
        o3 = o3 & 0xff;
        o4 = o4 & 0xff;

        o1 = o1 | this.o1;
        o2 = o2 | this.o2;
        o3 = o3 | this.o3;
        o4 = (o4 | this.o4);

        System.out.println(o4);

        if(o4 == 255){
            o4--;
            System.out.println(o4);
        }

        IPv4Address_Class lastHost = new IPv4Address_Class(o1, o2, o3, o4);

        return lastHost;
        
    }

    /*public int subnetMaskNumber(IP){}*/

    public String toString(){
        String s = "";

        s += o1 + "." + o2 + "." + o3 + "." + o4;

        return s;
    }
}
