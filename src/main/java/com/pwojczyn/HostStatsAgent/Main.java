package com.pwojczyn.HostStatsAgent;

import com.pwojczyn.HostStatsAgent.javasysmon.JavaSysMon;

public class Main {
    public static void main(String[] args) {
        System.out.println("HostStatsAgent 1.0");
/*
        try {
            JavaSysMon.SysMon();
        } catch (Exception e) {
            e.printStackTrace();
        }

*/
        Utils.runTask(new HostInfoTask(),1);
    }



}
