package edu.xavier.csci.williamst35;

import edu.xavier.csci.RomanNumeralConverter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class Controller {
    RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();

    @GetMapping("/decode/{id}")

    public ResponseSingleDecode decode(@PathVariable("id") String num) {
        ResponseSingleDecode response = new ResponseSingleDecode();

        response.setNumber(romanNumeralConverter.decode(num));

        return response;
    }


    @GetMapping("/encode/{id}")
    public ResponseSingleEncode encode(@PathVariable("id") int numb) {
        ResponseSingleEncode response = new ResponseSingleEncode();

        response.setNumber(romanNumeralConverter.encode(numb));

        return response;
    }

    @PostMapping("/decode")
    public ResponseMultipleDecode decode(@RequestBody List<String> x){
        ResponseMultipleDecode response = new ResponseMultipleDecode();
        List<Integer> y = new ArrayList<>();
        //loop through x, add decoded results to y
        for (String c : x){
            y.add(romanNumeralConverter.decode(c));
        }

        response.setNumbers(y);
        return response;
    }

    @PostMapping("/encode")
    public ResponseMultipleEncode encode(@RequestBody List<Integer> x){
        ResponseMultipleEncode response = new ResponseMultipleEncode();
        List<String> y = new ArrayList<>();
        //loop through x, add encoded results to y
        for (Integer c : x){
            y.add(romanNumeralConverter.encode(c));
        }

        response.setNumbers(y);
        return response;
    }

}