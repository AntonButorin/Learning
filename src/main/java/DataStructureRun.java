
public class DataStructureRun {

    public static void main(String... args) {
        DataStructure ds = new DataStructure();

        ds.print(ds.getEvenIterator());

        ds.print(new DataStructure.DataStructureIterator() {
            private int nextIndex = 1;

            public boolean hasNext() {
                return (nextIndex <= ds.getSIZE() - 1);
            }

            public Integer next() {
                Integer retValue = Integer.valueOf(ds.getArrayOfInts()[nextIndex]);
                nextIndex += 2;
                return retValue;
            }
        });

        ds.print(p -> p % 2 == 0);
        ds.print(p -> p % 2 != 0);

        ds.print(DataStructure::isEvenIndex);
        ds.print(DataStructure::isOddIndex);
    }
}



