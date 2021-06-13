package com.example.flightgearandroidapp.view_model;

import android.util.Log;

import com.example.flightgearandroidapp.model.FGPlayer;

public class ViewModel {
    private double aileron;
    private double elevator;
    private double rudder;
    private double throttle;
    private FGPlayer fgPlayer;

    public ViewModel(String IP, int port)
    {
        this.aileron = 0d;
        this.elevator = 0d;
        this.rudder = 0d;
        this.throttle = 0d;
        fgPlayer = new FGPlayer(IP, port);
    }



    public void setAileron(double a)
    {
        aileron = a;
        fgPlayer.setAileron(aileron);
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e) {

        }
        Log.i("setAileron","aileron: " + aileron);
    }

    public void setElevator(double e)
    {
        elevator = e;
        fgPlayer.setElevator(elevator);
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e2) {

        }
        Log.i("setElevator","elevator: " + elevator);
    }

    public void setRudder(double r)
    {
        rudder = r;
        fgPlayer.setRudder(rudder);
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e3) {

        }
        Log.i("setRudder","rudder: " + rudder);
    }

    public void setThrottle(double t)
    {
        throttle = t;
        fgPlayer.setThrottle(throttle);
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e4) {

        }
        Log.i("setThrottle","throttle: " + throttle);
    }




/**
    public void setAileron(double a)
    {
        aileron = a;
        fgPlayer.setValue(aileron);
        fgPlayer.setStr("flight/aileron ");
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e) {

        }
    }

    public void setElevator(double e)
    {
        elevator = e;
        fgPlayer.setValue(elevator);
        fgPlayer.setStr("flight/elevator ");
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e2) {

        }
    }

    public void setRudder(double r)
    {
        rudder = r;
        fgPlayer.setValue(rudder);
        fgPlayer.setStr("flight/rudder ");
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e3) {

        }
    }

    public void setThrottle(double t)
    {
        throttle = t;
        fgPlayer.setValue(throttle);
        fgPlayer.setStr("engines/current-engine/throttle ");
        try {
            fgPlayer.doSomething();
        } catch (InterruptedException e4) {

        }
    }
 **/



}
