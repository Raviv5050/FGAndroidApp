package com.example.flightgearandroidapp.model;

import android.util.Log;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FGPlayer {

    private double aileron;
    private double elevator;
    private double rudder;
    private double throttle;
    private Socket fg;
    private PrintWriter out;
    private String ip;
    private int port;
    private BlockingQueue<Runnable> dispatchQueue;

    private String str;
    private double value;

    public FGPlayer(String IP, int port)
    {
        this.aileron = 0d;
        this.elevator = 0d;
        this.rudder = 0d;
        this.throttle = 0d;
        this.ip = IP;
        this.port = port;
        this.dispatchQueue = new LinkedBlockingQueue<Runnable>();

        this.str = "";
        this.value = 0d;


        new Thread(() -> {
            try {
                fg = new Socket(ip, port);
            } catch (Exception e) {

            }

            try {
                out = new PrintWriter(fg.getOutputStream(), true);
            } catch (Exception e) {

            }
        }).start();


        new Thread (new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        dispatchQueue.take().run();
                    } catch (InterruptedException e) {
                        // okay, just terminate the dispatcher
                    }
                }
            }
        }
        ).start();
    }


    /**
    public void doSomething() throws InterruptedException {
        dispatchQueue.put(new Runnable() {
                              @Override
                              public void run() {
                                  String currentPath = "set /controls/"+ str;
                                  out.print(currentPath + value+"\r\n");
                                  out.flush();
                              }
                          }
        );
    }
     **/



    public void doSomething() throws InterruptedException {
        dispatchQueue.put(new Runnable() {
                              @Override
                              public void run() {
                                  out.print("set /controls/flight/aileron "+aileron+"\r\n");
                                  out.print("set /controls/flight/elevator "+elevator+"\r\n");
                                  out.print("set /controls/flight/rudder "+rudder+"\r\n");
                                  out.print("set /controls/engines/current-engine/throttle "+throttle+"\r\n");
                                  out.flush();
                              }
                          }
        );
    }


    public void setAileron(double a)
    {
        aileron = a;
        Log.i("setAileron","aileron: " + aileron);
    }

    public void setElevator(double e)
    {
        elevator = e;
        Log.i("setElevator","elevator: " + elevator);
    }

    public void setRudder(double r)
    {
        rudder = r;
        Log.i("setRudder","rudder: " + rudder);
    }

    public void setThrottle(double t)
    {
        throttle = t;
        Log.i("setThrottle","throttle: " + throttle);
    }



    public void setValue(double v)
    {
        this.value = v;
    }

    public void setStr(String currentStr)
    {
        this.str = currentStr;
    }

}
