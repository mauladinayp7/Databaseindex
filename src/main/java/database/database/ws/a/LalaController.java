/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.database.ws.a;

import database.database.ws.a.exceptions.NonexistentEntityException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mladi
 */
@Controller
@ResponseBody
public class LalaController {
    
    A2020ws data = new A2020ws();
    A2020wsJpaController actrl = new A2020wsJpaController();
    
    @RequestMapping("/getName/{id}")
    public String getName(@PathVariable("id") int id)
    {
        try {
            data = actrl.findA2020ws(id);
            return data.getName()+"<br>"+ data.getTglLahir();
        }
        catch (Exception error) {return "Data tidak ada";}
    }
    
    @RequestMapping ("/delete/{id}")
    public String deleteData(@PathVariable("id") int id){
        try {
            actrl.destroy(id);
            return id + "DELETED";
        }
        catch (NonexistentEntityException error){return id + "tidak ada";}
    }
}
