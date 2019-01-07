package com.codetudes.codetudesapi.config.seeding;

import com.codetudes.codetudesapi.domain.Codetude;
import com.codetudes.codetudesapi.domain.Image;
import com.codetudes.codetudesapi.domain.Tag;
import com.codetudes.codetudesapi.repositories.CodetudeRepository;
import com.codetudes.codetudesapi.repositories.ImageRepository;
import com.codetudes.codetudesapi.repositories.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.*;
import org.apache.commons.codec.binary.Base64;

@Component
public class SeedOnStartup {
    private Map tagMap = new HashMap<String, Tag>();
    private Map codetudeMap = new HashMap<String, Codetude>();
    private List imageList = new ArrayList<Long>();

    @Autowired
    private Environment env;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CodetudeRepository codetudeRepository;

    @Autowired
    private TagRepository tagRepository;
    
    @Autowired
    private ImageRepository imageRepository;


    @EventListener
    public void checkAndSeed(ContextRefreshedEvent event){
        if(Boolean.parseBoolean(env.getProperty("seed-db-on-startup"))){
            emptyTables();
            resetAutoIncrement();
            seed();
        }
    }

    private void emptyTables(){
        // order probably matters...
    	jdbcTemplate.execute("DELETE FROM `codetudes`.`image`        WHERE `id` > 0;");
        jdbcTemplate.execute("DELETE FROM `codetudes`.`tag`          WHERE `id` > 0;");
        jdbcTemplate.execute("DELETE FROM `codetudes`.`codetude`     WHERE `id` > 0;");
        jdbcTemplate.execute("DELETE FROM `codetudes`.`codetude_tag` WHERE `id` > 0;");
        jdbcTemplate.execute("DELETE FROM `codetudes`.`user`         WHERE `id` > 0;");
        jdbcTemplate.execute("DELETE FROM `codetudes`.`role`         WHERE `id` > 0;");
        jdbcTemplate.execute("DELETE FROM `codetudes`.`role_user`    WHERE `id` > 0;");
    }

    private void resetAutoIncrement(){
    	jdbcTemplate.execute("ALTER TABLE `codetudes`.`image`        AUTO_INCREMENT = 1;");
        jdbcTemplate.execute("ALTER TABLE `codetudes`.`tag`          AUTO_INCREMENT = 1;");
        jdbcTemplate.execute("ALTER TABLE `codetudes`.`codetude`     AUTO_INCREMENT = 1;");
        jdbcTemplate.execute("ALTER TABLE `codetudes`.`codetude_tag` AUTO_INCREMENT = 1;");
        jdbcTemplate.execute("ALTER TABLE `codetudes`.`user`         AUTO_INCREMENT = 1;");
        jdbcTemplate.execute("ALTER TABLE `codetudes`.`role`         AUTO_INCREMENT = 1;");
        jdbcTemplate.execute("ALTER TABLE `codetudes`.`role_user`    AUTO_INCREMENT = 1;");
    }

    private void seed(){
    	// Create Images
    	ArrayList imagePaths = new ArrayList<String>(
			Arrays.asList(
				"seeding-images/preview1.jpg",
				"seeding-images/preview2.jpg",
				"seeding-images/preview3.jpg",
				"seeding-images/preview4.jpg",
				"seeding-images/preview5.jpg",
				"seeding-images/preview6.jpg",
				"seeding-images/preview7.jpg",
				"seeding-images/preview8.png"
			)
		);
    	
    	imagePaths.forEach(path->{
    		createImage(loadImageFileAsBase64String((String) path));
    	});
	
    	
        // Create Tags
        String[] tagVals = new String[]{"Motif", "Piano", "Jazz", "A cappella", "Duet", "Polyphony", "Rondo", "Trill", "Waltz", "Sonata", "Prelude", "Trio", "Impressionism", "Pianissimo", "Compound Meter", "Minor", "Arpeggio", "Counter Melody"};

        for(String tagVal : tagVals){
            Tag tag = new Tag();
            tag.setName(tagVal);
            tagMap.put(tagVal, tagRepository.save(tag));
        }

        // Create Codetudes
        createCodetude("Moonlight Sonata",
                "Beethoven",
                "The heart-stoppingly beautiful first movement of Beethoven’s ‘Moonlight’ Sonata is the most famous from his work, and was described by composer Hector Berlioz as a ‘lamentation’. But it couldn’t be more different from the third movement, an epic technical work-out for the fingers.",
                0,
                "https://youtu.be/4Tr0otuiQuU",
                "https://youtu.be/4Tr0otuiQuU",
                false,
                getImageId(),
                new String[]{"Sonata", "Prelude", "Trio", "Trill", "Compound Meter"} );
        createCodetude("Clair de Lune",
                "Debussy",
                "Curiously, ‘Clair de Lune’ also means ‘Moonlight’ – but there’s a stark contrast between Beethoven’s Romantic classicism and Debussy’s Impressionism. Don’t be fooled by the initial simplicity of ‘Clair de Lune’: it took Debussy 15 years to write the third movement of the Suite Bergamasque, and the result is a work that sounds simple, but demands the very best from its performers. Get it right, and it allows the most accomplished pianists to shine.",
                null,
                "https://youtu.be/4fvo_iOuSck",
                "https://youtu.be/4fvo_iOuSck",
                true,
                getImageId(),
                new String[]{"Impressionism", "Pianissimo", "Compound Meter"} );
        createCodetude("Nocturne in E-flat Major (Op. 9, No. 2)",
                "Chopin",
                "Chopin composed his most well-known nocturne at the tender age of 20, which perhaps accounts for its youthful passion. The build-up from the main theme and waltz-like accompaniment to the dramatic trill-filled finale makes the Nocturne in E-flat Major a strong contender for the most beautiful piano work ever written.",
                -10,
                "https://youtu.be/tV5U8kVYS88",
                "https://youtu.be/tV5U8kVYS88",
                true,
                getImageId(),
                new String[]{"Minor", "Arpeggio", "Counter Melody", "Trill"} );
        createCodetude("Scenes from Childhood",
                "Schumann",
                "Schumann’s Kinderszenen are a bittersweet collection of piano miniatures covering themes like games of chase, night-time terrors, bedtime stories and sleep. The most famous, ‘Traumerei’ paints a peaceful musical picture of a child’s dreams. It’s tender and beautifully nostalgic.",
                -35,
                "https://youtu.be/yibf6QNjgGU",
                "https://youtu.be/yibf6QNjgGU",
                true,
                getImageId(),
                new String[]{"A cappella", "Duet", "Polyphony", "Compound Meter"} );
        createCodetude("The Well-Tempered Clavier",
                "J.S. Bach",
                "The Well-Tempered Clavier was completely innovative for its day, and it paved the way for composers writing for keyboard instruments for the next few hundred years. Bach wrote the first of the two books that make up his work in 1722, making this one of the earliest pieces on our list. Each of the two books contain 24 Preludes and Fugues (the whole work is sometimes known as ‘The 48’), in each key of the Western scale – and each book opens with a prelude in C major, closing with a fugue in B minor.",
                -65,
                "https://youtu.be/nPHIZw7HZq4",
                "https://youtu.be/nPHIZw7HZq4",
                true,
                getImageId(),
                new String[]{"Rondo", "Trill", "Waltz", "Motif"} );
        createCodetude("Rhapsody in Blue",
                "Gershwin",
                "'Rhapsody in Blue’ wasn’t entirely positively received by 1920s critics, yet its melange of classical and jazz style grounded Gershwin’s reputation as a serious composer – and its jazz influences are what gives the landmark piece its sultry and indulgent character.",
                0,
                "https://youtu.be/ss2GFGMu198",
                "https://youtu.be/ss2GFGMu198",
                true,
                getImageId(),
                new String[]{"Jazz", "Trill"} );
        createCodetude("Piano sonata in B minor",
                "Liszt",
                "By 1854, Liszt had put the finishing touches to his monumental Piano Sonata in B minor, and took the music to perform at a private soirée. Among the guests was another composer, Johannes Brahms. Liszt took his seat at the piano and began to play. When he reached a section of the piece of which he was particularly proud, so the story goes, he glanced over at Brahms to see what he thought… only to find his fellow composer snoozing. \n" +
                        "\n" +
                        "Despite its unfortunate first outing, this sonata has become one of the best-loved and most performed piano works. Traditionally, sonatas have four movements – but Liszt was never one to play by the rules. The Sonata in B minor is one unbroken stretch of music, built around a handful of motifs which re-appear in various guises throughout.",
                null,
                "https://youtu.be/68EMzR3Ct78",
                "https://youtu.be/68EMzR3Ct78",
                true,
                getImageId(),
                new String[]{"Minor", "Piano"} );
        createCodetude("Piano Concerto No.2 in C minor",
                "Rachmaninov",
                "Rachmaninov’s Second Piano Concerto has claimed our Classic FM Hall of Fame top spot eight times since the chart began in 1996… but what makes this unassailably epic work of genius so special? Is it the first movement’s contrast between solo piano passages and storming orchestral themes? Is it the emotionally syrupy second movement, which gave Brief Encounter its unforgettable soundtrack? Or is it the third movement’s epic virtuosic finale, under which the finest of pianists can crack? ",
                -95,
                "https://youtu.be/rEGOihjqO9w",
                "https://youtu.be/rEGOihjqO9w",
                true,
                getImageId(),
                new String[]{} );

    }

    /**
     * 
     * @param title
     * @param subtitle
     * @param description
     * @param startedOffset the number of days (+ or -) to add to current timestamp. Null value will make null date.
     * @param finishedOffset the number of days (+ or -) to add to current timestamp. Null value will make null date.
     * @param scl
     * @param ldl
     * @param live
     * @param previewImageId
     * @param tagVals
     */
    private void createCodetude(
            String title,
            String subtitle,
            String description,
            Integer startedOffset,
            String scl,
            String ldl,
            Boolean live,
            Long previewImageId,
            String[] tagVals){
        Codetude codetude = new Codetude();
        codetude.setStarted((startedOffset != null) ? new Date(System.currentTimeMillis() + ((long)startedOffset*1000*60*60*24)) : null);
        codetude.setTitle(title);
        codetude.setSubtitle(subtitle);
        codetude.setDescription(description);
        codetude.setSourceCodeLink(scl);
        codetude.setLiveDemoLink(ldl);
        codetude.setLive(live);
        codetude.setPreviewImageId(previewImageId);

        List<Tag> tags = new ArrayList<>();
        for(String tagVal : tagVals){
            tags.add((Tag)tagMap.get(tagVal));
        }
        codetude.setTags(tags);

        codetudeMap.put(title, codetudeRepository.save(codetude));
    }
    
    private String loadImageFileAsBase64String(String filePath){
    	String encodedFile = "";
        try {
        	ClassLoader classLoader = getClass().getClassLoader();
        	InputStream inputStreamReader = classLoader.getResourceAsStream(filePath);
            byte[] bytes = StreamUtils.copyToByteArray(inputStreamReader);
            inputStreamReader.close();
            encodedFile = new String(Base64.encodeBase64(bytes), "UTF-8");
            encodedFile = "data:image;base64," + encodedFile;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return encodedFile;
    }
    
    private void createImage(String value) {
    	Image image = new Image();
        image.setValue(value);
        
        image = imageRepository.save(image);
        imageList.add(image.getId());
    }
    
    private Long getImageId() {
    	if (imageList.isEmpty()) {
    		return null;
    	} else {
    		Long pickedId = (Long) imageList.get(0);
    		imageList.remove(0);
    		return pickedId;
    	}
    }
}
