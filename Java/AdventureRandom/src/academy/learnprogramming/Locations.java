package academy.learnprogramming;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")){
            rao.writeInt(locations.size());
            // multiple 3 because index is storing the index id, the offset for the location and the size of location record
            int indexSize = locations.size() * 3 * Integer.BYTES;
            // calculate the current position of the file pointer to the index size to account for the value that
            // we have already written to the file. We also have to account for the integer we are about to write
            // to the file the location section offset we just calculate (the number of bytes to an integer)
            // The file pointer is a long value, a good practice to cast to int
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);

            long indexStart = rao.getFilePointer();

            // write the location data first
            int startPointer = locationStart;
            rao.seek(startPointer);

            for (Location location: locations.values()) {
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction: location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                        // direction, locationId, direction, locationId
                        // N, 1, U , 2
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart);
            for (Integer locationID: index.keySet()) {
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }

        }

    }

    // 1. The first four bytes will contain the number of locations (bytes 0-3)
    // 2. the next four bytes will contain the start offset of the location section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1699)
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700.

    static {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while (ra.getFilePointer()<locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }

        } catch (IOException e) {
            System.out.println("IOException in static initializer: "+e.getMessage());
        }
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description, null);

        if (locationId!=0) {
            for (int i=0;i<exitPart.length;i++) {
                System.out.println("exitPart = "+exitPart[i]);
                System.out.println("exitPart[+1] = "+exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    public void close() throws IOException {
        ra.close();
    }
}
