package com.codingdojo.java.spring.demo.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.java.spring.demo.models.Answer;
import com.codingdojo.java.spring.demo.models.Question;
import com.codingdojo.java.spring.demo.models.Tag;
import com.codingdojo.java.spring.demo.repositories.AnswerRepository;
import com.codingdojo.java.spring.demo.repositories.QuestionRepository;
import com.codingdojo.java.spring.demo.repositories.TagRepository;
import org.springframework.stereotype.Service;



@Service
public class DojoOverflowService {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final AnswerRepository answerRepository;

    public DojoOverflowService (QuestionRepository questionRepository,
                                TagRepository tagRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
        this.answerRepository = answerRepository;
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public List<Tag> allTags() {
        return tagRepository.findAll();
    }

    public List<Answer> allAnswer() {
        return answerRepository.findAll();
    }

    public Question createQuestion(String question) {
        Question q = new Question(question);
        return questionRepository.save(q);
    }

    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag createStringTag (String tag) {
        Tag newTag = new Tag (tag);
        return tagRepository.save(newTag);
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        }
        else {
            return null;
        }
    }

    public Tag findBySubject(String subject) {
        return tagRepository.findBySubject(subject);
    }
}
