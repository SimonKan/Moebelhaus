package main;

import article.ConcreteArticle;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * 
 * @author Simon
 */
public class ArticleList {
    
   private List<ConcreteArticle> articles;
  
   public ArticleList(){
       articles = new ArrayList<ConcreteArticle>(); 
   }
   
   /**
    * 
    * neuer Konstruktor zum Übertragen der List<ConcreteArticle> in eine
    * {@link ArticleList}.
    * 
    * @param articles 
    */
   public ArticleList(List<ConcreteArticle> articles) {
       if(articles == null) {
           throw new IllegalArgumentException("articles was null");
       }
       this.articles = new ArrayList<ConcreteArticle>(articles);
   }
   
   public ArticleList getArticlesByName(String name) {
       if(name == null){
           throw new IllegalArgumentException("name was null");
       }
       name = name.trim().toLowerCase();
       if(name.isEmpty()){
           throw new IllegalArgumentException("name is empty");
       }
       List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();
       
       //Ermöglicht das suchen von Stichwörtern 
       Pattern pattern = Pattern.compile("\\.*" + name + "\\.*");
       
       for(ConcreteArticle article : articles) {
           if(pattern.matcher(article.getArticle().getName().toLowerCase()).matches()) {
               searchList.add(article);
           }
       }
       return new ArticleList(searchList);
   }
   
   public List<ConcreteArticle> toList(){
       return new ArrayList<ConcreteArticle>(articles);
   }
}