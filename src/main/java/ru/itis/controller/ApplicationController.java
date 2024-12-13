package ru.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.service.Combinatoric;
import ru.itis.service.UrnModel;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@Controller
public class ApplicationController {

    @GetMapping(value = "/")
    public String mainPage() {
        return "main";
    }

    @GetMapping(value = "/combinatoric")
    public String combinatoricPage() {
        return "combinatoric";
    }

    @GetMapping(value = "/urnmodel")
    public String urnModelPage() {
        return "urnmodel";
    }

    @PostMapping(value = "/calculateurnmodel")
    public String calculateurnmodel(@RequestParam("formType") String formtype,
                                    @RequestParam Map<String, String> params, Model model)  {

        Map<String, Integer> numericParams = new HashMap<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String value = entry.getValue();
            try {
                int intValue = Integer.parseInt(value);
                if (intValue < 0) {
                    model.addAttribute(formtype, "Введите положительное число");
                    return "combinatoric";
                }
                numericParams.put(entry.getKey(), intValue);
            } catch (NumberFormatException ignored) {
            }
        }

        if (formtype.equals("urnmodel")) {
            int n = Integer.parseInt(params.get("n"));
            int m = Integer.parseInt(params.get("m"));
            int k = Integer.parseInt(params.get("k"));
            if (n < 1) {
                model.addAttribute(formtype, "n должно быть больше 1");
                return "urnmodel";
            }
            if (m > n || k > n) {
                model.addAttribute(formtype, "m и k должны быть меньше n");
                return "urnmodel";
            }

            if (k > m) {
                model.addAttribute(formtype, "k должно быть меньше m");
                return "urnmodel";
            }

            BigDecimal result = UrnModel.samplingWithoutACertainNumber(n, m, k);
            model.addAttribute(formtype, result);
            return "urnmodel";
        }

        if (formtype.equals("urnmodelr")) {
            int n = Integer.parseInt(params.get("n"));
            int m = Integer.parseInt(params.get("m"));
            int k = Integer.parseInt(params.get("k"));
            int r = Integer.parseInt(params.get("r"));
            if (n < 1) {
                model.addAttribute(formtype, "n должно быть больше 1");
                return "urnmodel";
            }
            if (m > n || k > n) {
                model.addAttribute(formtype, "m и k должны быть меньше n");
                return "urnmodel";
            }

            if (k > m) {
                model.addAttribute(formtype, "k должно быть меньше m");
                return "urnmodel";
            }
            if (r > k) {
                model.addAttribute(formtype, "r должно быть меньше k");
                return "urnmodel";
            }
            BigDecimal result = UrnModel.samplingWithACertainNumber(n, m, k, r);
            model.addAttribute(formtype, result);
            return "urnmodel";
        }
        return "urnmodel";
    }

    @PostMapping(value = "/calculate")
    public String processForm(@RequestParam("formType") String formtype,
                              @RequestParam Map<String, String> params,
                              Model model) {

        Map<String, Integer> numericParams = new HashMap<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String value = entry.getValue();
            try {
                if (value.length() > 5 && Character.toString(value.charAt(0)).matches("\\d")) {
                    model.addAttribute(formtype.replaceAll("-", "") + "result", "Слишком большое число");
                    return "combinatoric";
                }
                int intValue = Integer.parseInt(value);
                if (intValue < 0) {
                    model.addAttribute(formtype.replaceAll("-", "") + "result", "Введите положительное число");
                    return "combinatoric";
                }
                numericParams.put(entry.getKey(), intValue);
            } catch (NumberFormatException ignored) {
            }
        }
        if (formtype.equals("permutations-no-repeat")) {
            int n = Integer.parseInt(params.get("n"));
            BigInteger result = Combinatoric.getPermutation(n);
            model.addAttribute(formtype.replaceAll("-", "") + "result", result);
        }
        if (formtype.equals("permutations-repeat")) {
            int[] nums = new int[params.size()];
            Collection<Integer> paramValues = numericParams.values();
            int i = 0;
            for (Integer paramValue : paramValues) {
                nums[i++] = paramValue;
            }
            BigInteger result = Combinatoric.getPermutationWithRepeat(nums);
            model.addAttribute(formtype.replaceAll("-", "") + "result", result);
        }
        if (formtype.equals("placement-repeat")) {
            int n = Integer.parseInt(params.get("n"));
            int k = Integer.parseInt(params.get("k"));
            if (k > n) {
                model.addAttribute(formtype.replaceAll("-", "") + "result", "k должно быть меньше n");
                return "combinatoric";
            }
            BigInteger result = Combinatoric.getPlacementWithRepeat(n, k);
            model.addAttribute(formtype.replaceAll("-", "") + "result", result);
        }
        if (formtype.equals("placement-no-repeat")) {
            int n = Integer.parseInt(params.get("n"));
            int k = Integer.parseInt(params.get("k"));
            System.out.println(n);
            System.out.println(k);
            if (k > n) {
                model.addAttribute(formtype.replaceAll("-", "") + "result", "k должно быть меньше n");
                return "combinatoric";
            }
            BigInteger result = Combinatoric.getPlacement(n, k);
            model.addAttribute(formtype.replaceAll("-", "") + "result", result);
        }
        if (formtype.equals("combination-repeat")) {
            int n = Integer.parseInt(params.get("n"));
            int k = Integer.parseInt(params.get("k"));
            if (k > n || n < 1) {
                model.addAttribute(formtype.replaceAll("-", "") + "result", "k должно быть меньше n и n должно быть больше 1");
                return "combinatoric";
            }
            BigInteger result = Combinatoric.getCombination(n, k);
            model.addAttribute(formtype.replaceAll("-", "") + "result", result);
        }
        if (formtype.equals("combination-no-repeat")) {
            int n = Integer.parseInt(params.get("n"));
            int k = Integer.parseInt(params.get("k"));
            if (k > n) {
                model.addAttribute(formtype.replaceAll("-", "") + "result", "k должно быть меньше n");
                return "combinatoric";
            }
            BigInteger result = Combinatoric.getCombinationWithRepeat(n, k);
            model.addAttribute(formtype.replaceAll("-", "") + "result", result);
        }


        return "combinatoric";
    }

}

