package com.tigersystemseller.rest.clients;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tigersystemseller.model.Client;
import com.tigersystemseller.model.repository.ClientRepository;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientController {
     @Autowired
     private ClientRepository repository;
     
     @PostMapping
     public ResponseEntity<ClientFormRequest> saveClient(@RequestBody ClientFormRequest request) {
    	 Client client = request.toModel(); //alt + shift + l => create variable
    	 repository.save(client);
    	 return ResponseEntity.ok(ClientFormRequest.fromModel(client));
     }
     @PutMapping("{id}")
     public ResponseEntity<ClientFormRequest> saveClient(@PathVariable Long id, @RequestBody ClientFormRequest request) {
    	 Optional<Client> existsClient = repository.findById(id);    	 
    	 if(existsClient.isEmpty()) {
    		 return ResponseEntity.notFound().build();
    	 }
    	 Client client = request.toModel();
    	 client.setId(id);
    	 repository.save(client);
    	 return ResponseEntity.noContent().build();
     }
     @GetMapping("{id}")
     public ResponseEntity<ClientFormRequest> getById(@PathVariable Long id){
    	 return repository.findById(id)
    			 .map(ClientFormRequest::fromModel)
    			 .map(clientFR -> ResponseEntity.ok(clientFR))
    			 .orElseGet(() -> ResponseEntity.notFound().build());
     }
     @DeleteMapping("{id}")
     public ResponseEntity<Object> deleteClient(@PathVariable Long id){
    	 return repository.findById(id)
    			 .map( client -> {
    				 repository.delete(client);
    				 return ResponseEntity.noContent().build();
    			 })
    			 .orElseGet(() -> ResponseEntity.notFound().build());
     }
     
     @GetMapping
     public Page<ClientFormRequest> getList(
    		 @RequestParam(value = "name", required = false, defaultValue = "") String name,
    		 @RequestParam(value = "cpf", required = false, defaultValue = "" ) String cpf,
    		 Pageable pageable){
    	 return repository
    			 .searchNameCpf("%" + name + "%", "%" + cpf + "%", pageable)
    			 .map(ClientFormRequest::fromModel);
     }
}
