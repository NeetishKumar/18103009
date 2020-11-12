document.getElementById("myButton").addEventListener("click", function()
    {
        var x = document.getElementById("string").value;
        
        var arr = new Array();
        
        var ans=true;
        
        var last;
        
        for(var i=0;i<x.length;i++)
        {
            if(x.charAt(i)=="(")
            {
                arr.push(1);
            }
            
            else if(x.charAt(i)=="[")
            {
                arr.push(2);
            }
            
            else if(x.charAt(i)=="{")
            {
                arr.push(3);
            }
            
            else if(x.charAt(i)==")")
            {
                if(arr.length==0)
                {
                    ans=false;
                    break;
                }
                
                last = arr.pop();
                
                if(last!=1)
                {
                    ans=false;
                    break;
                }
            }
            
            else if(x.charAt(i)=="]")
            {
                if(arr.length==0)
                {
                    ans=false;
                    break;
                }
                
                last = arr.pop();
                
                if(last!=2)
                {
                    ans=false;
                    break;
                }
            }
            else if(x.charAt(i)=="}")
            {
                if(arr.length==0)
                {
                    ans=false;
                    break;
                }
                
                last = arr.pop();
                
                if(last!=3)
                {
                    ans=false;
                    break;
                }
            }
        }
        
        if(arr.length!=0)
        {
            ans=false;
        }
        
        if(ans==true)
        {
            alert(x + " is Balanced");
        }
        
        else
        {
            alert(x + " is Unbalanced");
        }

    }, false);