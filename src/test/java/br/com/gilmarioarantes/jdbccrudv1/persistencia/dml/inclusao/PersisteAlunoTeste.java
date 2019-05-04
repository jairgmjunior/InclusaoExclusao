package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraListaAlunos;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.text.resources.FormatData;

import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PersisteAlunoTeste {

    Logger logger = Logger.getLogger(PersisteAlunoTeste.class.getName());

    @Test
    public void persisteAlunoTest(){

        logger.info("Executando o método persisteAlunoTest() da classe: " + this.getClass().getSimpleName());

        List<Aluno> alunos = GeraListaAlunos.geraLista();

        boolean result = false;

        try{
            for(Aluno aluno : alunos){
                result = new PersisteAluno().persisteAluno(aluno);
            }
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }

    @Test
    public void incluirAlunoTest(){
        logger.info("Executando o método incluirAlunoTest() da classe: " + this.getClass().getSimpleName());

        Aluno aluno = new Aluno((long)42, "1234912559", "Primeiro alunoffaas", "Masculino", new Timestamp(System.currentTimeMillis()));

        boolean result = false;

        try {

            result = new PersisteAluno().persisteAluno(aluno);

        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o aluno", e);
        }
    }


}
