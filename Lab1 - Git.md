## **IES Lab1-1.2**
Author: Gabriela Santos
Student number: 51531

 - Created  the following remote repository for the project from the previous exercise:
[https://github.com/gabsw/ies-lab1](https://github.com/gabsw/ies-lab1)
 - Created a new branch (feature1) in order to develop a feature to add logging to the project;
 - Merged (fast forward) feature1 with master;
 - Created a new branch (feature2) in order to develop a feature to accept both the cityId and cityName as valid parameters to retrieve weather data;
Modified the use of logging;
- Merged (fast forward) feature2 with master.

This method of work didn't allow me to come across merging conflicts to solve.

## Git - Study Notes
*Clone over HTTPS*

Go to the directory where you want to clone your repository
`
git clone https://address
`

*Create new branch*
`git branch name`

*Enter new branch*
`git checkout name`

*Last 2 commands in one*
`git checkout -b name`

*Merge new branch back to master*
`git checkout master`
`git merge branch_name`

*For a simpler and readable log output*
`git log --all --decorate --oneline --graph`

*Stage and commit all the modified files*
`git -a -m "Commit message"`

*Show what will change between branches before a merge*
`git diff branch1..branch2"`

*Confirm which branches have merged*
`git branch --merged"`

*Fast forward merge*
When there is a direct path between the updated branch and the branch you want to merge with (No other merges have happened to the main path)

*3-way merge*
When there isn't a direct path between your current branch and the main branch, new features have already been introduced. If we try to do a fast forward merge, the new features would have been lost.

*Solving error of partial commit during merge, after solving merge conflicts*
```
git commit -i -m "Fixing merge" 
```
Stage the file that is missing.

*Save changes in master and checkout for another branch*
`git stash`
Add `list -p` to check the changes
`git stash apply stash@{1}`
Applies a stage using its code

> Written with [StackEdit](https://stackedit.io/).
