package gta2.raw.sty.structures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileCorruptException;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StyCarInfo {
    private int model;
    private int sprite;
    private int w;
    private int h;
    private int numRemaps;
    private int passengers;
    private int wreck;
    private int rating;
    private int frontWheelOffset;
    private int rearWheelOffset;
    private int frontWindowOffset;
    private int rearWindowOffset;
    private int infoFlags;
    private int infoFlags2;
    private int[] remap;
    private int numDoors;
    private List<StyDoorInfo> doors;
    
    public int getModel() {
        return model;
    }

    public int getSprite() {
        return sprite;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getNumRemaps() {
        return numRemaps;
    }

    public int getPassengers() {
        return passengers;
    }

    public int getWreck() {
        return wreck;
    }

    public int getRating() {
        return rating;
    }

    public int getFrontWheelOffset() {
        return frontWheelOffset;
    }

    public int getRearWheelOffset() {
        return rearWheelOffset;
    }

    public int getFrontWindowOffset() {
        return frontWindowOffset;
    }

    public int getRearWindowOffset() {
        return rearWindowOffset;
    }

    public int getInfoFlags() {
        return infoFlags;
    }

    public int getInfoFlags2() {
        return infoFlags2;
    }

    public int[] getRemap() {
        return remap;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public List<StyDoorInfo> getDoors() {
        return doors;
    }

    public static class StyCarInfoReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StyCarInfo> carInfo = new ArrayList<>();
            long read = 0;
            while(read < chunkSize) {
                StyCarInfo car = new StyCarInfo();
                car.model = input.readUInt8();
                car.w = input.readUInt8();
                car.h = input.readUInt8();
                car.numRemaps = input.readUInt8();
                car.passengers = input.readUInt8();
                car.wreck = input.readUInt8();
                car.rating = input.readUInt8();
                car.frontWheelOffset = input.readByte();
                car.rearWheelOffset = input.readByte();
                car.frontWindowOffset = input.readByte();
                car.rearWindowOffset = input.readByte();
                car.infoFlags = input.readUInt8();
                car.infoFlags2 = input.readUInt8();
                car.remap = input.readUInt8Array(car.numRemaps);
                car.numDoors = input.readUInt8();
                car.doors = readDoorInfo(input, car.numDoors);
                carInfo.add(car);
                read += 14 + car.numRemaps + car.numDoors * 2;
            }
            if(read != chunkSize) {
                throw new StyFileCorruptException();
            }
        }

        private List<StyDoorInfo> readDoorInfo(RawInputStream input, int numDoors) throws IOException {
            List<StyDoorInfo> doors = new ArrayList<>();
            for(int i = 0; i < numDoors; ++i) {
                int rx = input.readByte();
                int ry = input.readByte();
                doors.add(new StyDoorInfo(rx, ry));
            }
            return doors;
        }
    }
}
