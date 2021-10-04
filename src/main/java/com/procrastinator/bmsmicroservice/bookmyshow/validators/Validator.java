package com.procrastinator.bmsmicroservice.bookmyshow.validators;

import com.procrastinator.bmsmicroservice.bookmyshow.model.Movie;
import com.procrastinator.bmsmicroservice.bookmyshow.model.User;

/*default methods in interface can have body like normal methods
  introduced in java 8
  e.g. Our interface have been implemented by 10 classes and now we want to add
  a method which is not required by those 10 classes.
   SO we can use default keyword to add implmentation of new method in interface*/
public interface Validator {
    default void requestValidation(User user) throws Exception {}
    default void requestValidation(Movie movie) throws Exception {}


}
