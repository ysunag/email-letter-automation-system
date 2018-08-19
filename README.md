# email-letter-automation-system
The program needs to accept certain arguments at the command line.

        --email                  only generate email messages
        --email-template <file>  accepts a filename that holds the email template

        --letter                 only generate letters
        --letter-template <file> accepts a filename that holds the email template


        --output-dir <path>      accepts the name of a folder, all output is placed in this folder
        --csv-file <path>        accepts the name of the csv file to process
        If --email is given, then --email-template must also be provided, if --letter is given then 
        --letter-template must also be given. 
        Calling the program and passing any other combination of options will generate an error, 
        e.g. --email --letter-template letter-template.txt --output-dir letters/ is illegal.
