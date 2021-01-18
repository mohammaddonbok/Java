package com.codingdojo.java.spring.demo.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;

import com.codingdojo.java.spring.demo.models.Answer;
import com.codingdojo.java.spring.demo.models.Question;
import com.codingdojo.java.spring.demo.models.Tag;
import com.codingdojo.java.spring.demo.services.DojoOverflowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class DojoOverflowController {
    private final DojoOverflowService dojoOverflowService;

    public DojoOverflowController(DojoOverflowService dojoOverflowService) {
        this.dojoOverflowService = dojoOverflowService;
    }

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/questions")
    public String dashboard(Model model) {
        List<Question> questions = dojoOverflowService.allQuestions();
        model.addAttribute("questions", questions);
        return "dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String createQuestion(Model model, @ModelAttribute("askquestion") Question askquestion) {
        model.addAttribute("askquestion", askquestion);
        return "newquestion.jsp";
    }

    @RequestMapping("/questions/new/process")
    public String createQuestionProcess(@RequestParam (value = "question") String question,
                                        @RequestParam (value = "tags") String tags) {
        String smalltags = tags.toLowerCase();
        String [] listOfTags = smalltags.split(",");
        List<String> allTags = Arrays.asList(listOfTags);

        if (question.length() < 1) {
            return "redirect:/emptyquestion";
        }
        else if (tags.length() < 1) {
            return "redirect:/emptytags";
        }
        else if (allTags.size() > 3) {
            return "redirect:/toomanytags";
        }
        else {
            Question q = dojoOverflowService.createQuestion(question);
            ArrayList<Tag> allTagsConv = new ArrayList<Tag>();

            for (int i = 0; i < allTags.size(); i++) {
                Tag findTag = dojoOverflowService.findBySubject(allTags.get(i));
                if (findTag == null) {
                    Tag t = dojoOverflowService.createStringTag(allTags.get(i));
                    allTagsConv.add(t);
                }
                else {
                    allTagsConv.add(findTag);
                }
            }
            q.setTags(allTagsConv);
            dojoOverflowService.updateQuestion(q);
            return "redirect:/questions";
        }
    }

    @RequestMapping("/emptyquestion")
    public String emptyQuestion (RedirectAttributes r) {
        r.addFlashAttribute("question", "Question field cannot be blank");
        return "redirect:/questions/new";
    }

    @RequestMapping("/emptytags")
    public String emptyTags (RedirectAttributes r) {
        r.addFlashAttribute("tag", "Tag field cannot be blank");
        return "redirect:/questions/new";
    }

    @RequestMapping("/toomanytags")
    public String tooManyTags (RedirectAttributes r) {
        r.addFlashAttribute("tag", "Question cannot have more than three tags");
        return "redirect:/questions/new";
    }

    @RequestMapping("/questions/{id}")
    public String answers (Model model, @PathVariable("id") Long id) {
        Question question = dojoOverflowService.findQuestion(id);
        model.addAttribute("question", question);
        return "answers.jsp";
    }

    @RequestMapping("/questions/{id}/answer")
    public String answerQuestion (@PathVariable("id") Long id,
                                  @RequestParam (value = "answer") String answer, HttpSession session) {
        if (answer.length() < 2) {
            session.setAttribute("id", id);
            return "redirect:/noanswer";
        }
        else {
            Answer a = new Answer();
            a.setAnswer(answer);
            Question question = dojoOverflowService.findQuestion(id);
            a.setQuestion(question);
            dojoOverflowService.createAnswer(a);
            return "redirect:/questions/" + id;
        }
    }

    @RequestMapping("/noanswer")
    public String noAnswer (RedirectAttributes r, HttpSession session) {
        r.addFlashAttribute("answer", "Answer must be two or more characters long");
        Long id = (Long) session.getAttribute("id");
        return "redirect:/questions/" + id;
    }
}
