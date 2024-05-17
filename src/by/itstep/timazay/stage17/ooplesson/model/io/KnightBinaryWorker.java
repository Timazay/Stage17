package by.itstep.timazay.stage17.ooplesson.model.io;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Knight;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;

import java.io.*;

public class KnightBinaryWorker {

    public static void writeArmor(String fileName, Armor armor) {
        DataOutputStream stream;
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

    public static void writeWeapon(String fileName, Weapon weapon) {
        DataOutputStream stream;
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

            stream.writeUTF(armor.getName());
            stream.writeDouble(armor.getPrice());
            stream.writeDouble(armor.getWeight());
            stream.writeInt(armor.getDefence());

            stream.writeUTF(weapon.getName());
            stream.writeDouble(weapon.getPrice());
            stream.writeDouble(weapon.getWeight());
            stream.writeDouble(weapon.getDamage());

            Inventory inventory = knight.getInventory();

            stream.writeDouble(inventory.getMaxWeight());
            stream.writeInt(inventory.getSize());

            for (int i = 0; i < inventory.getSize(); i++) {
                Ammunition ammunition = inventory.get(i);

                if (ammunition instanceof Armor) {
                    stream.writeInt(0);
                    stream.writeUTF(ammunition.getName());
                    stream.writeDouble(ammunition.getPrice());
                    stream.writeDouble(ammunition.getWeight());
                    stream.writeInt(((Armor) ammunition).getDefence());
                } else {
                    stream.writeInt(1);
                    stream.writeUTF(ammunition.getName());
                    stream.writeDouble(ammunition.getPrice());
                    stream.writeDouble(ammunition.getWeight());
                    stream.writeDouble(((Weapon) ammunition).getDamage());
                }
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

    public static void writeInventory(String fileName, Inventory inventory) {
        DataOutputStream stream;
        stream = null;

        try {
            stream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)));

            stream.writeDouble(inventory.getMaxWeight());
           stream.writeInt(inventory.getSize());

            for (int i = 0; i < inventory.getSize(); i++) {
                Ammunition ammunition = inventory.get(i);

                if (ammunition instanceof Armor) {
                    stream.writeInt(0);
                    stream.writeUTF(ammunition.getName());
                    stream.writeDouble(ammunition.getPrice());
                    stream.writeDouble(ammunition.getWeight());
                    stream.writeInt(((Armor) ammunition).getDefence());
                } else {
                    stream.writeInt(1);
                    stream.writeUTF(ammunition.getName());
                    stream.writeDouble(ammunition.getPrice());
                    stream.writeDouble(ammunition.getWeight());
                    stream.writeDouble(((Weapon) ammunition).getDamage());
                }
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

    public static Ammunition readArmor(String fileName) {
        DataInputStream stream = null;
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

    public static Ammunition readWeapon(String fileName) {
        DataInputStream stream = null;
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

    public static Inventory readInventory(String fileName) {
        DataInputStream stream = null;
        Inventory inventory = new Inventory();
        try {
            stream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)));

            inventory.setMaxWeight(stream.readDouble());
            int size = stream.readInt();

            for (int i = 0; i < size; i++) {
                int type = stream.readInt();
                String name = stream.readUTF();
                double price = stream.readDouble();
                double weight = stream.readDouble();
                if (type == 0) {
                    int defense = stream.readInt();
                    inventory.add(new Armor(name, price, weight, defense));
                } else if (type == 1) {
                    double damage = stream.readDouble();
                    inventory.add(new Weapon(name, price, weight, damage));
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

            armor.setName(stream.readUTF());
            armor.setPrice(stream.readDouble());
            armor.setWeight(stream.readDouble());
            armor.setDefence(stream.readInt());

            weapon.setName(stream.readUTF());
            weapon.setPrice(stream.readDouble());
            weapon.setWeight(stream.readDouble());
            weapon.setDamage(stream.readDouble());

            Inventory inventory = new Inventory();

            inventory.setMaxWeight(stream.readDouble());
            int size = stream.readInt();

            for (int i = 0; i < size; i++) {
                int type = stream.readInt();
                String name = stream.readUTF();
                double price = stream.readDouble();
                double weight = stream.readDouble();

                if (type == 0) {
                    int defense = stream.readInt();
                    inventory.add(new Armor(name, price, weight, defense));
                } else if (type == 1) {
                    double damage = stream.readDouble();
                    inventory.add(new Weapon(name, price, weight, damage));
                }

                knight.setInventory(inventory);
                inventory.add(armor);
                inventory.add(weapon);

                knight.equipArmor(armor);
                knight.equipWeapon(weapon);

            }
        }catch (IOException exception) {
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
