package main;

import article.ConcreteArticle;
import java.util.ArrayList;
import java.util.List;

public class ArticleList {
    
   private List<ConcreteArticle> articleList;
  
   public ArticleList(){
       articleList = new ArrayList<ConcreteArticle>(); 
   }

}