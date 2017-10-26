package com.pwojczyn.HostStatsAgent;

import java.util.TimerTask;

public class HostInfoTask extends TimerTask {
    public HostInfoTask() {
        //constructor
    }

    public void run() {
        try {
            //hostname

            HostInfo hostInfo = new HostInfo();
//            String       postUrl       = "http://localhost:5051/rest/hostinfo/apikey/bfc6c0979f536fe36745f96f5818d268/hostkey/bfks873hdkhbdkah242/";// put in your url
            String       postUrl       = Config.API_URL+Config.API_HOSTINFO_URL+hostInfo.getHostId()+"/"; // put in your url
//            String       postUrl       = "http://localhost:5051/"+Config.API_HOSTINFO_URL+hostInfo.getHostId()+"/";

            // send hostInfo update
            Utils.post(postUrl,hostInfo);


        } catch (Exception ex) {

            System.out.println("error running thread " + ex.getMessage());
        }
    }

}
