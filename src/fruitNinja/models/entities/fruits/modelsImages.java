package fruitNinja.models.entities.fruits;

import fruitNinja.data.services.FruitDataService;


public class modelsImages {
    FruitDataService fruitDataService = new FruitDataService();
    OrdinaryFruitFactory fruitFactory=new OrdinaryFruitFactory();
    public modelsImages() {
    }

    public void setImages() {

        for (FruitData fruitData: fruitDataService.readData()){
            switch (fruitData.getFruitname()){
                case "banana":
                   // Banana.setImage(fruitData.getPicture());
                   // System.out.println("in banana"+Banana.getImage());
                    break;
                case "apple":
                    //Apple.setImage(fruitData.getPicture());
                    // System.out.println("in apple"+Apple.getImage());
                    break;
                case "pineapple":
                    //Pineapple.setImage(fruitData.getPicture());
                    //System.out.println("in pineapple"+Pineapple.getImage());
                    break;
            }


        }
    }
 }


