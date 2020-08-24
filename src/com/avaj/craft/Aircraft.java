package com.avaj.craft;

import com.avaj.interfaces.Coordinates;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static Long _idCounter = 0L;

    protected Aircraft(String name, Coordinates coordinates) {
        this.coordinates = coordinates;
        this.name = name;
        this._idCounter = nextid();
        this.id = this._idCounter;
    }
    private long nextid() {
        return (++_idCounter);
    }
    public  Coordinates getCoordinates() {
        return this.coordinates;
    }
}
