package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificarController
{
    @GetMapping("/palindromo/{word}")
    public String palindromo(@PathVariable String word)
    {
        return word.toUpperCase() + esPalindromo(word) + "es un palindormo";
    }

    /**
     * La logica no debe ir en una clase Controller
     * esta clase solo debe encargarse de atender solicitudes http
     * @param word
     * @return
     */
    private String esPalindromo(String word)
    {
        int pD = word.length();
        for (int pI = 0; pI < word.length() / 2; pI++)
        {
            if (word.charAt(pI) != word.charAt(--pD))
            {
                return " NO ";
            }
        }
        return " ";
    }
}
