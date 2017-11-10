package com.pwojczyn.HostStatsAgent;



public class Main {
    public static void main(String[] args) {
        // cmd: java -jar hoststatsagent.jar bfc6c0979f536fe36745f96f5818d268 &
        String apikey;

        if (args.length == 0){
            // for test only
            apikey = "bfc6c0979f536fe36745f96f5818d268";
            System.out.println("HostStatsAgent 1.10");
        }else{
            apikey=args[0];
        }


//        try {
//            JavaSysMon.SysMon();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        Utils.runTask(new HostInfoTask(apikey),5);
    }



}
