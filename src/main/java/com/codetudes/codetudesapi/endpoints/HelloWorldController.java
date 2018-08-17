package com.codetudes.codetudesapi.endpoints;

        import com.codetudes.codetudesapi.domain.Codetude;
        import com.codetudes.codetudesapi.domain.Tag;
        import com.codetudes.codetudesapi.repositories.CodetudeRepository;
        import com.codetudes.codetudesapi.repositories.TagRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.ArrayList;
        import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    CodetudeRepository codetudeRepository;

    @Autowired
    TagRepository tagRepository;

    @GetMapping
    public String helloWorld(){

        // Create tags
        Tag htmlTag = new Tag();
        htmlTag.setName("HTML");
        htmlTag = tagRepository.save(htmlTag);

        Tag cssTag = new Tag();
        cssTag.setName("CSS");
        cssTag = tagRepository.save(cssTag);

        Tag javascriptTag = new Tag();
        javascriptTag.setName("Javascript");
        javascriptTag = tagRepository.save(javascriptTag);

        List<Tag> tags = new ArrayList<Tag>();
        tags.add(htmlTag);
        tags.add(cssTag);
        tags.add(javascriptTag);


        // Create codetudes
        Codetude codetude1 = new Codetude();
        codetude1.setTags(tags);
        codetude1 = codetudeRepository.save(codetude1);

        htmlTag.setName("html");
        tagRepository.save(htmlTag);

//        codetudeRepository.delete(codetude1);


        return "Finished";
    }
}
