
# Secret Events
Android app for handling surprise travel arrangements. After it's finished, it will be used as the base for my mobile testing skill development.

The *Secret Events* app, which is being developed, is intended to be an interactive guide to various tours - especially surprise ones.

User can enter, previously obtained secret passphrase. After that, pre-defined hidden record is revealed. Clicking the freshly displayed record on the list, moves user to the *Detailed Event* layout, where Title, Description, Photo, Activity image and date is shown.
Clicking on the address opens Google Maps app with the address automatically searched. This eliminates the burden of manual searching for places.

## How it works?
- After running, the user is greeted by a personalized gif, depending on the occasion of the trip it lasts for the predefined time (which is usually a gif duration - now 13,5 seconds) or can be interrupted with a long click;
- *Main List* layout contains app title, list of already revealed events with their Titles, Photo miniatures, Addresses and Dates information. Also, the *Question Mark Floating Button* is shown always over the list;
- After clicking on the *Question Mark Floating Button*, user is redirected to the *Add passphrase* layout;, where they can enter previously obtained passphrase, accept it or cancel:
    - If passphrase is correct - a Modal is shown, asking if user really want to execute the reveal:
        - The Modal confirmation updates the DB, shows cheerful toast and redirects user to the *Main list* layout;
        - The Modal cancellation shows sad toast and keeps user in the *Add passphrase* layout;
    - If passphrase is incorrect:
        - Case that passphrase already was revealed - appropriate message under an input field;
        - Case that passphrase does not exist - appropriate message under an input field;
- After clicking on the single list record item a user is redirected to the *Detailed Event* layout;
  - Inside the *Detailed Event* layout all closer details about the event are shown:
    - Event title;
    - Event photo;
    - Event type icon and it's name;
    - Event address in slightly green font;
      - Click on this section opens Google Maps app with automatically searched address;
    - Event description highlighting everything that user should know;
  - Clicking on the Back button moves user back to the *Main List* layout
    