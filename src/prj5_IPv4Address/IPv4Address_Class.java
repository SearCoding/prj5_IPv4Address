package prj5_IPv4Address;

/**
 * Represents an IPv4 address.
 */
public class IPv4Address_Class {
    
    private int o1, o2, o3, o4;

    /**
     * Default constructor.
     */
    public IPv4Address_Class(){}

    /**
     * Constructor with initial values for octets.
     * @param a First octet value.
     * @param b Second octet value.
     * @param c Third octet value.
     * @param d Fourth octet value.
     */
    public IPv4Address_Class(int a, int b, int c, int d){
        this.o1 = a;
        this.o2 = b;
        this.o3 = c;
        this.o4 = d;
    }

    /**
     * Get the first octet.
     * @return The value of the first octet.
     */
    public int getoctectOne(){
        return o1;
    }

    /**
     * Get the second octet.
     * @return The value of the second octet.
     */
    public int getoctectTwo(){
        return o2;
    }

    /**
     * Get the third octet.
     * @return The value of the third octet.
     */
    public int getoctectThree(){
        return o3;
    }

    /**
     * Get the fourth octet.
     * @return The value of the fourth octet.
     */
    public int getoctectFour(){
        return o4;
    }

    /**
     * Identifies the network address using the provided mask.
     * @param mask The mask to be applied.
     * @return The network address.
     */
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

    /**
     * Identifies the first host address.
     * @return The first host address.
     */
    public IPv4Address_Class identifyFirstHost(){
        o4++;
        IPv4Address_Class firstHost = new IPv4Address_Class(o1, o2, o3, o4);
        return firstHost;
    }

    /**
     * Identifies the last host address using the provided mask.
     * @param mask The mask to be applied.
     * @return The last host address.
     */
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
        o4 = (o4 | this.o4) - 1;

        if(o4 == 255){
            o4--;
        }

        IPv4Address_Class lastHost = new IPv4Address_Class(o1, o2, o3, o4);
        return lastHost;
    }

    /**
     * Returns a string representation of the IPv4 address.
     * @return The string representation of the IPv4 address.
     */
    public String toString(){
        return o1 + "." + o2 + "." + o3 + "." + o4;
    }
}

