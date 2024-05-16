package by.itstep.timazay.stage17.ooplesson.model.io;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Knight;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;

import java.io.*;

public class KnightBinaryWorker {
    private static int[] input;

    public static void writeArmor(String fileName, Armor armor, DataOutputStream stream) {
        //   DataOutputStream stream;
        stream = null;

        try {
            stream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)));

            stream.writeUTF(armor.getName());
            stream.writeDouble(armor.getPrice());
            stream.writeDouble(armor.getWeight());
            stream.writeInt(armor.getDefence());
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }
    }

    public static void writeWeapon(String fileName, Weapon weapon, DataOutputStream stream) {
        //     DataOutputStream stream;
        stream = null;

        try {
            stream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)));

            stream.writeUTF(weapon.getName());
            stream.writeDouble(weapon.getPrice());
            stream.writeDouble(weapon.getWeight());
            stream.writeDouble(weapon.getDamage());

        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }
    }

    public static void writeKnight(String fileName, Knight knight) {
        DataOutputStream stream;
        stream = null;
        Weapon weapon = knight.getWeapon();
        Armor armor = knight.getArmor();

        try {
            stream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)));

            stream.writeUTF(knight.getName());
            stream.writeDouble(knight.getWallet());
            stream.writeDouble(knight.getHealth());
            writeArmor(fileName, armor, stream);

            writeWeapon(fileName, weapon, stream);

            Inventory inventory = knight.getInventory();

            if (inventory != null) {
                writeInventory(fileName, inventory, stream);
            }

        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }

    }

    public static void writeInventory(String fileName, Inventory inventory, DataOutputStream stream) {
        //     DataOutputStream stream;
        stream = null;

        try {
            stream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)));


            stream.writeInt(inventory.getSize());
            stream.writeDouble(inventory.getMaxWeight());
            int i = 0;
            input = new int[inventory.getSize()];

            for (Ammunition ammunition : inventory) {
                if (ammunition instanceof Armor) {
                    writeArmor(fileName, (Armor) ammunition, stream);
                    input[i] = 0;
                } else if (ammunition instanceof Weapon) {
                    writeWeapon(fileName, (Weapon) ammunition, stream);
                    input[i] = 1;
                }
                i++;
            }
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }

    }

    public static Ammunition readArmor(String fileName, DataInputStream stream) {
        stream = null;
        Ammunition ammunition = null;

        try {
            stream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)));

            String name = stream.readUTF();
            double price = stream.readDouble();
            double weight = stream.readDouble();
            int value = stream.readInt();
            ammunition = new Armor(name, price, weight, value);

        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }

        return ammunition;
    }

    public static Ammunition readWeapon(String fileName, DataInputStream stream) {
        stream = null;
        Ammunition ammunition = null;

        try {
            stream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)));

            String name = stream.readUTF();
            double price = stream.readDouble();
            double weight = stream.readDouble();
            double value = stream.readDouble();
            ammunition = new Weapon(name, price, weight, value);

        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }

        return ammunition;
    }

    public static Inventory readInventory(String fileName, DataInputStream stream) {
        stream = null;
        Inventory inventory = new Inventory();
        Ammunition ammunition = null;
        try {
            stream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)));
            int size = stream.readInt();

            inventory.setMaxWeight(stream.readDouble());

            for (int i = 0; i < size; i++) {
                if (input[i] == 0) {
                    inventory.add(readArmor(fileName, stream));
                } else if (input[i] == 1) {
                    inventory.add(readWeapon(fileName, stream));
                }
            }
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }
        return inventory;
    }

    public static Knight readKnight(String fileName) {
        DataInputStream stream = null;

        Knight knight = new Knight();

        try {
            stream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)));

            Armor armor = new Armor();
            Weapon weapon = new Weapon();
            knight.setName(stream.readUTF());
            knight.setWallet(stream.readDouble());
            knight.setHealth(stream.readDouble());
            knight.setAlive(stream.readBoolean());
            armor = (Armor) readArmor(fileName, stream);

            weapon = (Weapon) readWeapon(fileName, stream);

            Inventory inventory = readInventory(fileName, stream);
            knight.setInventory(inventory);
            inventory.add(armor);
            inventory.add(weapon);

            knight.equipArmor(armor);
            knight.equipWeapon(weapon);

        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException exception) {
                System.out.println(exception);
            }
        }
        return knight;
    }


}