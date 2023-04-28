# Secret Events
Android app for handling surprise travel arrangements. After it's finished, it will be also used as the base for my mobile testing skill development.

<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235269355-34354bf3-65ac-4a94-835a-bdbb4097cae2.jpg">
</p>

The **Secret Events** app, which is being developed, is intended to be an interactive guide to various tours - especially surprise ones.

User can enter, previously obtained secret passphrase. After that, pre-defined hidden record is revealed. Clicking the freshly displayed record on the list, moves user to the **Detailed Event** layout, where Title, Description, Photo, Activity image and date is shown.
Clicking on the address opens Google Maps app with the address automatically searched. This eliminates the burden of manual searching for places.

## Flowchart
<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235268427-2800aad0-413d-4ab3-9620-967ab8a622de.jpg">
</p>

## How it works?
- After running, the user is greeted by a personalized gif, depending on the occasion of the trip it lasts for the predefined time (which is usually a gif duration - now 13,5 seconds) or can be interrupted with a long click;

<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235269559-5acd2d67-cdda-46d3-917e-2e02fd542da7.jpg">
</p>

- **Main List** layout contains app title, list of already revealed events with their Titles, Photo miniatures, Addresses and Dates information. Also, the **Question Mark Floating Button** is shown always over the list;
<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235269812-c0a01cbf-5782-4e7f-8c68-72299104af40.jpg">
</p>

- After clicking on the **Question Mark Floating Button**, user is redirected to the **Add passphrase** layout, where they can enter previously obtained passphrase, accept it or cancel:

<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235269953-a286b765-1d98-4890-af84-75816760de3d.jpg">
</p>

 If passphrase is correct - a Modal is shown, asking if user really want to execute the reveal:
    - The Modal confirmation updates the DB, shows cheerful toast and redirects user to the **Main list** layout - on which there is a confetti splash shown along with two fanfares for 3 seconds;
    - The Modal cancellation shows sad toast and keeps user in the **Add passphrase** layout;
    
<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235270126-a9f0cb1e-02cc-4718-80bf-17ade47feec7.jpg">
</p>

- If passphrase is incorrect:
    - Case that passphrase already was revealed - appropriate message under an input field;
    - Case that passphrase does not exist - appropriate message under an input field;
     
<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235270279-27ab696b-e1ed-46b6-b1b9-04eba5fe1b84.jpg">
</p>
  
- After clicking on the single list record item a user is redirected to the **Detailed Event** layout;
    - Inside the **Detailed Event** layout all closer details about the event are shown:
        - Event title;
        - Event photo;
        - Event type icon and it's name;
        - Event address in slightly green font;
            - Click on this section opens Google Maps app with automatically searched address;
        - Event description highlighting everything that user should know;
    - Clicking on the Back button moves user back to the **Main List** layout
      
<p align="center">
<img src="https://user-images.githubusercontent.com/45639693/235270815-4046b914-37de-4f07-a5c1-67c1a1b9a52c.jpg">
</p>    
        
