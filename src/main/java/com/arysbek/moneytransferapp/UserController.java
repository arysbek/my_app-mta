package com.arysbek.moneytransferapp;

import com.arysbek.moneytransferapp.model.Transaction;
import com.arysbek.moneytransferapp.model.User;
import com.arysbek.moneytransferapp.repository.TransactionRepository;
import com.arysbek.moneytransferapp.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    //Read user
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
    }

//    // Find transaction using userRepository by user id
//    @GetMapping("/{id}/transactions")
//    public ResponseEntity<Iterable<Transaction>> findByUserId(@PathVariable Long id){
//
//        User user = userRepository.findById(id).get();
//        return new ResponseEntity<>(user.getTransactions(), HttpStatus.OK);
//    }


    // Find transaction using transactionRepository by user id
    @GetMapping("/{id}/transactions")
    public ResponseEntity<Iterable<Transaction>> findTransactionsByUserId(@PathVariable Long id){

        Iterable<Transaction> transactions = transactionRepository.findByUserId(id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    // Read All users
    @GetMapping("/")
    public ResponseEntity<Iterable<User>> index(){
        return ResponseEntity.ok()
                            .header("Request-Id", "request-id")
                            .body(userRepository.findAll());
    }

    // Create user
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user){
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    // Update User
    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable Long id){

        User savedUser = userRepository.findById(id).get();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            savedUser = objectMapper.updateValue(savedUser,user);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        userRepository.save(savedUser);
        return savedUser;
    }
    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Search User by first_name @RequestParam is used for search
    @GetMapping("/search")
    public ResponseEntity<Object> search(@RequestParam(required = false, name = "firstName")String firstName,
                                         @RequestParam(required = false, name = "lastName")String lastName,
                                         @RequestParam(required = false, name = "Email")String Email) {

        Iterable<User> iterable;
        if (firstName != null && lastName != null) {
            iterable = userRepository.findTop10ByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            iterable = userRepository.findTop10ByFirstName(firstName);
        } else if (lastName != null) {
            iterable = userRepository.findTop10ByLastName(lastName);
        } else {
            iterable = userRepository.findAllTopTen();
        }

//        int count = 0;
//        List<User> newUsersList = new ArrayList<>();
//        Iterator<User> iterator = iterable.iterator();
//
//        while (iterator.hasNext() && count < 10) {
//            newUsersList.add(iterator.next());
//            count++;
//        }
//        return ResponseEntity.ok().body(newUsersList);
        return ResponseEntity.ok(iterable);
    }
}


///  @Controller
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    //Read user
//    @GetMapping("/{id}")
//    public @ResponseBody
//    User findOne(@PathVariable Long id){
//        return this.userRepository.findById(id).get();
//    }
//    //Read All users
//    @GetMapping("/")
//    public Iterable<User> index(){
//        return userRepository.findAll();
//    }
//    //Create user
//    @PostMapping("/")
//    public User create(@RequestBody User user){
//        userRepository.save(user);
//        return user;
//    }
//    // Update User
//    @PutMapping("/{id}")
//    public User update(@RequestBody User user, @PathVariable Long id){
//
//        User savedUser = userRepository.findById(id).get();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        try {
//            savedUser = objectMapper.updateValue(savedUser,user);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        }
//        userRepository.save(savedUser);
//        return savedUser;
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> delete(@PathVariable Long id){
//        try{
//            userRepository.deleteById(id);
//        }catch (EmptyResultDataAccessException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}

///Response entity types
// Read user
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> findOne(@PathVariable Long id){
//        Optional<User> optionalUser = userRepository.findById(id);
//        if(!optionalUser.isPresent()){
//            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
//    }