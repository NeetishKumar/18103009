// Execute using Nodejs

// 4. JavaScript to print christmas tree pattern.

function printTree(treeHeight)
{
    for (let i = 0; i < treeHeight; i++) 
    { 
        let str = ''; 
        for (let j = 1; j < treeHeight-i; j++)
            str = str + ' '; 
        
        for (let k = 1; k <= (2*i+1); k++)
        {            
            if(i == 0) 
            	str = str + '*';
            else 
            	str = str + '0'; 
        } 
        
        console.log(str); 
    } 
}

let treeHeight = 10;                         // Tree height is taken as 10.
printTree(treeHeight)