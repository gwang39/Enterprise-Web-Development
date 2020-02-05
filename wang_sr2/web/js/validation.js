/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This function validates party size, start date, duration input in the quote form
 * @returns {Boolean}
 */

function validation() 
{
    var size = document.forms["quoteForm"]["size"].value;
    var year = document.forms["quoteForm"]["year"].value;
    var month = document.forms["quoteForm"]["month"].value;
    var day = document.forms["quoteForm"]["day"].value;
    var duration = document.forms["quoteForm"]["duration"].value;
    
    
    if (size > 0 && size < 11)
    {// check party size
        if(year > 2004 && year < 2021 && month > 0 && month < 13 && day >0 && day <32)
         {// check start date
             if (duration > 1 && duration < 8)
             {//check duration
                 return true
             }
            else
            {
                alert("Invalid Duration");
                return false;
            }

             
         }

         else
         {
             alert("Invalid Date: Please Check Start Date");
             return false;
         }


    } else 
    {
       alert("Invalid party size (MIN 1 MAX 10)");
       return false;
    }

   
    
    
}