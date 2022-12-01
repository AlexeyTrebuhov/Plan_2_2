package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        interface GameItem {
            void open();
        }

        class GoldReward implements GameItem {
            @Override
            public void open() {
                // todo add open business logic
                System.out.println("GoldReward opened");
            }
        }

        class GemReward implements GameItem {
            @Override
            public void open() {
                // todo add open business logic
                System.out.println("GemReward opened");
            }
        }
        abstract class ItemGenerator {

            public void openReward() {
                // ... other code ...
                GameItem gameItem = createItem();
                gameItem.open();
            }

            /**
             * Subclasses will override this method in order to create
             * specific reward objects.
             */
            public abstract GameItem createItem();

        }
        class GoldGenerator extends ItemGenerator{
            @Override
            public GameItem createItem() {
                return new GoldReward();
            }
        }

        class GemGenerator extends ItemGenerator{
            @Override
            public GameItem createItem() {
                return new GemReward();
            }
        }

        class Game {

            public static void main(String[] args) {
                Random random = ThreadLocalRandom.current();
                List<ItemGenerator> generatorList = new ArrayList<>();
                generatorList.add(new GemGenerator());
                generatorList.add(new GoldGenerator());

                for (int i = 0; i < 10; i ++){
                    int idx = Math.abs(random.nextInt() % 2) == 0 ? 0 : 1;
                    ItemGenerator itemGenerator = generatorList.get(idx);
                    itemGenerator.openReward();
                    System.out.println(itemGenerator);
                }
            }
        }









    }
}