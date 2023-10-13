package gta2.raw.sty.structures;

import java.io.IOException;
import java.util.List;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StySpecs {
    private List<Integer> grassDirtTiles;
    private List<Integer> roadSpecialTiles;
    private List<Integer> waterTiles;
    private List<Integer> electrifiedTiles;
    private List<Integer> electrifiedPlatformTiles;
    private List<Integer> woodFloorTiles;
    private List<Integer> metalFloorTiles;
    private List<Integer> metalWallTiles;
    private List<Integer> grassDirtWallTiles;
    
    public StySpecs() {
        super();
    }

    public List<Integer> getGrassDirtTiles() {
        return grassDirtTiles;
    }

    public List<Integer> getRoadSpecialTiles() {
        return roadSpecialTiles;
    }

    public List<Integer> getWaterTiles() {
        return waterTiles;
    }

    public List<Integer> getElectrifiedTiles() {
        return electrifiedTiles;
    }

    public List<Integer> getElectrifiedPlatformTiles() {
        return electrifiedPlatformTiles;
    }

    public List<Integer> getWoodFloorTiles() {
        return woodFloorTiles;
    }

    public List<Integer> getMetalFloorTiles() {
        return metalFloorTiles;
    }

    public List<Integer> getMetalWallTiles() {
        return metalWallTiles;
    }

    public List<Integer> getGrassDirtWallTiles() {
        return grassDirtWallTiles;
    }

    public static class StySpecsReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            StySpecs specs = new StySpecs();
            specs.grassDirtTiles = input.readZtUInt16List();
            specs.roadSpecialTiles = input.readZtUInt16List();
            specs.waterTiles = input.readZtUInt16List();
            specs.electrifiedTiles = input.readZtUInt16List();
            specs.electrifiedPlatformTiles = input.readZtUInt16List();
            specs.woodFloorTiles = input.readZtUInt16List();
            specs.metalFloorTiles = input.readZtUInt16List();
            specs.metalWallTiles = input.readZtUInt16List();
            specs.grassDirtWallTiles = input.readZtUInt16List();
            dst.setSpecs(specs);
        }
    }
}
