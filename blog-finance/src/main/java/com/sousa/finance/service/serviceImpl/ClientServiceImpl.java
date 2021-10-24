package com.sousa.finance.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sousa.finance.consumers.v3.ClientClient;
import com.sousa.finance.service.ClientService;
import com.sousa.finance.vo.v3.client.ClientVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static com.sousa.finance.util.JsonParserUtil.parser;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientClient client;

    @Override
    public ModelAndView consumeAPIGetClient(Optional<String> transactionId){
        ModelAndView mv = new ModelAndView("fragments/result::result");
        ResponseEntity<String> respose = client.getByTransactionId(transactionId);
        mv.addObject("response",respose.getBody() );
        try {
            mv.addObject("object", ((ClientVO)parser(ClientVO.class, respose.getBody())));
//            mv.addObject("object", mockObjectClientVO());
        } catch (Exception e) {
            mv.addObject("message", String.format("Error parsing service return: GetClient Erro: %s", e.getMessage()));
        }
        return mv;
    }

    //TODO Method to assist in screen development, erase after application stability.
    private ClientVO mockObjectClientVO(){
        Path resourceDirectory = Paths.get("src","test","resources","client-get.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClientVO clientVO = objectMapper.readValue(
                    new File(resourceDirectory.toFile().getAbsolutePath()),
                    ClientVO.class);
            return clientVO;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
