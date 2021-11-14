package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AnimalProperties.class)
public class AnimalConfiguration {

    /**
     * @ConditionalOnMissingBean annotation 을
     * 추가하면 두 번째 페이즈 동작 시 해당 type의 bean이 없을 경우에만
     * 생성해 주도록 하여 오류가 발생 하지 않게 된다.
     */

    @Bean
    @ConditionalOnMissingBean
    public Animal animal(AnimalProperties animalProperties) {
        Animal animal = new Animal();
        animal.setName(animalProperties.getName());
        animal.setAge(animalProperties.getAge());
        return animal;
    }
}
