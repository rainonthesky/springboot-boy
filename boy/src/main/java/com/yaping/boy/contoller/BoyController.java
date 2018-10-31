package com.yaping.boy.contoller;
import com.yaping.boy.aspect.HttpAspect;
import com.yaping.boy.domain.Boy;
import com.yaping.boy.domain.Result;
import com.yaping.boy.respsitory.BoyRepository;
import com.yaping.boy.service.BoyService;
import com.yaping.boy.utils.ResultUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BoyController {
    private final static org.slf4j.Logger logger =  LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    private BoyRepository boyProperties;
    @Autowired
    private BoyService boyService;
    @GetMapping(value = "boys")
    public List<Boy>boyList(){
        logger.info("boyList");
       return boyProperties.findAll();
    }
    /**
     * 添加对象
     */
    @PostMapping(value = "/boys")
   public  Result<Boy>  boyAdd(@Valid Boy boy, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
         return ResultUtils.failed(1,bindingResult.getFieldError().getDefaultMessage());
        }

        boy.setCupSize(boy.getCupSize());
        boy.setAge(boy.getAge());
        return ResultUtils.sucees(boyProperties.save(boy));
    }
    @GetMapping(value = "/boys/{id}")
    Boy boyFindOne(@PathVariable("id") Integer id){
        return boyProperties.findOneById(id);
    }

    /**
     * 更新
     * @return
     */
    @PutMapping(value = "/boys/{id}")
    Boy boyUpdate(@PathVariable("id")Integer id,@RequestParam("cupSize")String cupSize,@RequestParam("age")Integer age){
        Boy boy=new Boy();
        boy.setId(id);
        boy.setCupSize(cupSize);
        boy.setAge(age);
    return boyProperties.save(boy) ;
    }
    @DeleteMapping("/boys/{id}")
    public void boyDelete(@PathVariable("id")Integer id){
        boyProperties.deleteById(id);
    }
    // 通过年龄进行查询
    @GetMapping(value = "/boys/ages/{age}")
    public List<Boy>boyListByAge(@PathVariable("age")Integer age){
        return  boyProperties.findBoyByAge(age);
    }
    @GetMapping(value ="boys/getages/{id}")
    public void  getAge(@PathVariable("id") Integer id)throws Exception{
        boyService.getAges(id);
    }


}
