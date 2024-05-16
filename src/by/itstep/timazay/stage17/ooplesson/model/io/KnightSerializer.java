package by.itstep.timazay.stage17.ooplesson.model.io;

import by.itstep.timazay.stage17.ooplesson.model.entity.Knight;

import java.io.*;

public class KnightSerializer {

        public static void serialize(String fileName, Knight knight) {
            try(ObjectOutputStream stream = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)))) {

                stream.writeObject(knight);
                stream.flush();

            } catch (IOException exception){
                System.out.println(exception);
            }
        }
        public static Knight deserialize(String fileName) {
            Knight knight = null;
            try(ObjectInputStream stream = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)))) {

                knight = (Knight) stream.readObject();


            } catch (ClassNotFoundException | IOException exception){
                System.out.println(exception);
            }
            return knight;
        }
}
