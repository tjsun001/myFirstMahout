package com.prediction.marketing.recomender;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thurmansanders
 * Date: 6/26/14
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemRecomender  {
    public static void main(String[] args) {
        DataModel dataModel;
        try{
        dataModel = new FileDataModel(new File("data/u.csv"));
            ItemSimilarity itemSimilarity = new LogLikelihoodSimilarity(dataModel);
            GenericItemBasedRecommender genericItemBasedRecommender = new GenericItemBasedRecommender(dataModel,itemSimilarity);
            int counter = 1;
            for (LongPrimitiveIterator items = dataModel.getItemIDs();items.hasNext();){
                Long itemId = items.nextLong();
                List<RecommendedItem> recommendedItems = genericItemBasedRecommender.mostSimilarItems(itemId,5);
                for (RecommendedItem recomendation :recommendedItems){
                    System.out.println(itemId + " , " + recomendation.getItemID() + recomendation.getValue());
                    }
                counter++;
                if (counter > 38) {
                    System.exit(1);
                }
            }


    }catch(IOException e){
            System.out.println("there was an error");
            e.printStackTrace();
        }
        catch(TasteException e){
            System.out.println("there was a taste exception ");
        }
    }
}
