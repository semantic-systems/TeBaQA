package de.uni.leipzig.tebaqa.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnswerToQuestion {
    private Set<String> answer;
    private Map<String, String> rdfEntities;
    private String answerType;
    private String sparqlQuery;

    public AnswerToQuestion(ResultsetBinding answer, Map<String, String> entitiyToQuestionMapping) {
        this.answer = new HashSet<>();
        this.answer.addAll(answer.getResult());
        this.sparqlQuery = answer.getQuery();
        this.rdfEntities = entitiyToQuestionMapping;

        if (!this.answer.isEmpty() && this.answer.parallelStream().allMatch(a -> a.startsWith("http://dbpedia.org/"))) {
            this.answerType = "uri";
        } else {
            //NO uri but date, string or number
            if (this.answer.parallelStream().allMatch(StringUtils::isNumeric)) {
                this.answerType = "number";
            } else {
                this.answerType = "literal";
            }
        }
    }

    public Set<String> getAnswer() {
        return answer;
    }

    public String getAnswerType() {
        return answerType;
    }

    public String getSparqlQuery() {
        return sparqlQuery;
    }

    @Override
    public String toString() {
        return "AnswerToQuestion{" +
                "answer=" + answer +
                ", rdfEntities=" + rdfEntities +
                ", answerType='" + answerType + '\'' +
                ", sparqlQuery='" + sparqlQuery + '\'' +
                '}';
    }
}
